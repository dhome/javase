package ch.h2m.edu.nosql.cassandra;

import java.util.Arrays;
import java.util.UUID;
import java.util.logging.LogRecord;
import me.prettyprint.cassandra.model.RowImpl;
import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.ThriftKsDef;
import me.prettyprint.cassandra.service.template.ColumnFamilyResult;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ColumnFamilyUpdater;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.Serializer;
import me.prettyprint.hector.api.beans.Row;
import me.prettyprint.hector.api.ddl.ColumnFamilyDefinition;
import me.prettyprint.hector.api.ddl.ComparatorType;
import me.prettyprint.hector.api.ddl.KeyspaceDefinition;
import me.prettyprint.hector.api.exceptions.HectorException;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hector.api.mutation.MutationResult;
import me.prettyprint.hector.api.mutation.Mutator;

/**
 *
 * @author Heinz
 */
public class Hector {

    Cluster myCluster;
    ColumnFamilyDefinition cfDefLog;
    ColumnFamilyDefinition cfDefJms;
//    ColumnFamily cfJms;
//    ColumnFamily cfLog;
    ColumnFamilyTemplate<String, String> template_log;
    ColumnFamilyTemplate<String, String> template_jms;
    Keyspace ksp;
    
    
    final static StringSerializer ss = StringSerializer.get();
    final String COLUMNFAMILYNAME_LOG = "log";
    final String COLUMNFAMILYNAME_JMS = "jms";
    final String KEYSPACE = "ENAPP";

    public Hector() {
        myCluster = HFactory.getOrCreateCluster("test-cluster", "localhost:9160");
        cfDefLog = HFactory.createColumnFamilyDefinition(
                KEYSPACE,
                COLUMNFAMILYNAME_LOG,
                ComparatorType.BYTESTYPE);
        cfDefJms = HFactory.createColumnFamilyDefinition(
                KEYSPACE,
                COLUMNFAMILYNAME_JMS,
                ComparatorType.BYTESTYPE);

        // If keyspace does not exist, the CFs don't exist either. => create them.
        if (myCluster.describeKeyspace(KEYSPACE) == null) {
            createSchema();
        }
        ksp = HFactory.createKeyspace(KEYSPACE, myCluster);

        template_log = new ThriftColumnFamilyTemplate<String, String>(
                ksp,
                COLUMNFAMILYNAME_LOG,
                StringSerializer.get(),
                StringSerializer.get());
        template_jms = new ThriftColumnFamilyTemplate<String, String>(
                ksp,
                COLUMNFAMILYNAME_JMS,
                StringSerializer.get(),
                StringSerializer.get());
    }

    private void createSchema() {
        KeyspaceDefinition newKeyspace = HFactory.createKeyspaceDefinition(KEYSPACE,
                ThriftKsDef.DEF_STRATEGY_CLASS,
                1, //replicationFactor
                Arrays.asList(cfDefLog, cfDefJms));

        // Add the schema to the cluster.
        // "true" as the second param means that Hector will block until all nodes see the change.
        myCluster.addKeyspace(newKeyspace, true);
    }

    public void updateLog(LogRecord log) {
        // <String, String> correspond to key and Column name.
        ColumnFamilyUpdater<String, String> updater = template_log.createUpdater(COLUMNFAMILYNAME_LOG);
        updater.setInteger("level",       log.getLevel().intValue() );
        updater.setString("message",      log.getMessage() );
        updater.setLong("time",           log.getMillis());
        updater.setLong("sequenceNumber", log.getSequenceNumber());
        updater.setString("className",    log.getSourceClassName() );
        updater.setString("methodName",   log.getSourceMethodName() );
        updater.setUUID("uuid", UUID.randomUUID());
        try {
            template_log.update(updater);
        } catch (HectorException e) {
            System.err.println(e.toString());
        }
    }

    public void updateJms(String value) {
        // <String, String> correspond to key and Column name.
        ColumnFamilyUpdater<String, String> updater = template_jms.createUpdater(COLUMNFAMILYNAME_JMS);
        updater.setString("value", value);
        updater.setUUID("uuid", UUID.randomUUID());
        updater.setLong("time", System.currentTimeMillis());
        try {
            template_jms.update(updater);
        } catch (HectorException e) {
            System.err.println(e.toString());
        }
    }

    public String getLog() {
        try {
            ColumnFamilyResult<String, String> res = template_log.queryColumns(COLUMNFAMILYNAME_LOG);
            return res.getString("time");
        } catch (HectorException e) {
            System.err.println(e.toString());
        }
        return "";
    }
    
    public String getJms() {
        try {
            ColumnFamilyResult<String, String> res = template_jms.queryColumns(COLUMNFAMILYNAME_JMS);
            return res.getString("value");
        } catch (HectorException e) {
            System.err.println(e.toString());
        }
        return "";
    }
    
    public void createLogEntry(LogRecord logRecord) {
        String key = UUID.randomUUID().toString();
        Mutator<String> m1 = HFactory.createMutator(ksp, ss);
        m1.addInsertion(
                key, COLUMNFAMILYNAME_LOG,
                HFactory.createStringColumn("level", logRecord.getLevel().toString()));
        m1.addInsertion(
                key, COLUMNFAMILYNAME_LOG,
                HFactory.createStringColumn("message", logRecord.getMessage()));
        m1.addInsertion(
                key, COLUMNFAMILYNAME_LOG,
                HFactory.createStringColumn("time", logRecord.getMillis()+""));
        m1.addInsertion(
                key, COLUMNFAMILYNAME_LOG,
                HFactory.createStringColumn("sequenceNumber", logRecord.getSequenceNumber()+""));
        m1.addInsertion(
                key, COLUMNFAMILYNAME_LOG,
                HFactory.createStringColumn("className", logRecord.getSourceClassName()));
        m1.addInsertion(
                key, COLUMNFAMILYNAME_LOG,
                HFactory.createStringColumn("methodName", logRecord.getSourceMethodName()));
        MutationResult execute = m1.execute();
        System.out.println( execute.toString() );
    }
    
    
}
