package br.com.fiap.microservicesexercicio1;


import br.com.fiap.payment.PaymentApplication;
import br.com.fiap.payment.model.PaymentDTO;
import br.com.fiap.payment.service.PaymentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class )
@SpringBootTest(classes = PaymentApplication.class)
public class PaymentServiceTest {


    @Mock
    private PaymentService paymentService;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(paymentService.save(any(PaymentDTO.class)))
                .thenReturn(new PaymentDTO());
    }


    @Test
    public void paymentServiceTest() {
        Assert.assertNotNull(paymentService.save(new PaymentDTO()));
    }

}