package hu.odrin7.pof.pcfredis.controllers;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.model.PaymentObjectReference;
import hu.odrin7.pof.pcfredis.services.PaymentService;
import hu.odrin7.pof.pcfredis.tranings.PaymentIdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;
    @MockBean
    private PaymentIdService paymentIdService;

    @Test
    public void getAllPaymentIds() throws Exception {
        when(paymentService.getAllPaymentId()).thenReturn(givenPaymentId());

        mockMvc.perform(get("/payment-set")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(content()
                        .string("{\"hu.odrin7.pof.pcfredis.model." +
                                "PaymentObjectReference@6a513ad\":{\"objectReference\":" +
                                "{\"dom\":\"dom\",\"refId\":\"refid\"},\"groupId\":1," +
                                "\"relationReferenceId\":[]}}"));
    }

    @Test
    public void getAllObjectReletion() throws Exception {

        when(paymentService.getAllObjectReletion()).thenReturn(givenRelations());

        mockMvc.perform(get("/payment-hash")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(content()
                        .string("{\"1\":{\"id\":1,\"objectReferenceFirst\"" +
                                ":{\"dom\":\"dom\",\"refId\":\"refid\"},\"objectReferenceSecond\"" +
                                ":{\"dom\":\"dom1\",\"refId\":\"refid1\"},\"recordedDomain\":\"recordedDomain\"," +
                                "\"transactionReference\":\"transref\",\"recordedDomainNotes\":[\"note1\",\"note2\"]}}"));
    }

    private Map<PaymentObjectReference, PaymentId> givenPaymentId() {
        Map<PaymentObjectReference, PaymentId> givenPayments = new HashMap<>();
        givenPayments.put(new PaymentObjectReference("dom", "refid"),
                new PaymentId(new PaymentObjectReference("dom", "refid"),
                        1L, new HashSet<>()));
        return givenPayments;
    }

    private Map<Long, ObjectRelation> givenRelations() {
        Map<Long, ObjectRelation> givenRelation = new HashMap<>();
        givenRelation.put(1L, givenRelation());
        return givenRelation;
    }

    private ObjectRelation givenRelation() {
        return new ObjectRelation(1L,
                new PaymentObjectReference("dom", "refid"),
                new PaymentObjectReference("dom1", "refid1"),
                "recordedDomain", "transref", asList("note1", "note2"));
    }
}