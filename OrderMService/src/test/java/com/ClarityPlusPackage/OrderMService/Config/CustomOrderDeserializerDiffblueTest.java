package com.ClarityPlusPackage.OrderMService.Config;

import com.ClarityPlusPackage.OrderMService.Entity.Order;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomOrderDeserializerDiffblueTest {

    /**
     * Method under test:
     * {@link CustomOrderDeserializer#deserialize(JsonParser, DeserializationContext)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeserialize() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.fasterxml.jackson.core.ObjectCodec.readTree(com.fasterxml.jackson.core.JsonParser)" because the return value of "com.fasterxml.jackson.core.JsonParser.getCodec()" is null
        //       at com.ClarityPlusPackage.OrderMService.Config.CustomOrderDeserializer.deserialize(CustomOrderDeserializer.java:19)
        //   See https://diff.blue/R013 to resolve this issue.

        CustomOrderDeserializer customOrderDeserializer = new CustomOrderDeserializer();
        JsonParserDelegate jsonParser = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
        customOrderDeserializer.deserialize(jsonParser,
                new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));
    }
    /**
     * Method under test:
     * {@link CustomOrderDeserializer#deserialize(JsonParser, DeserializationContext)}
     */
    //    @Test
    //    @Disabled("TODO: Complete this test")
    //    void testDeserialize() throws IOException {
    //        // TODO: Complete this test.
    //        //   Reason: R013 No inputs found that don't throw a trivial exception.
    //        //   Diffblue Cover tried to run the arrange/act section, but the method under
    //        //   test threw
    //        //   java.lang.NullPointerException: Cannot invoke "com.fasterxml.jackson.core.ObjectCodec.readTree(com.fasterxml.jackson.core.JsonParser)" because the return value of "com.fasterxml.jackson.core.JsonParser.getCodec()" is null
    //        //       at com.ClarityPlusPackage.OrderMService.Config.CustomOrderDeserializer.deserialize(CustomOrderDeserializer.java:19)
    //        //   See https://diff.blue/R013 to resolve this issue.
    //
    //        CustomOrderDeserializer customOrderDeserializer = new CustomOrderDeserializer();
    //        JsonParserDelegate jsonParser = new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance()));
    //        customOrderDeserializer.deserialize(jsonParser,
    //                new DefaultDeserializationContext.Impl(new BeanDeserializerFactory(new DeserializerFactoryConfig())));
    //    }
}
