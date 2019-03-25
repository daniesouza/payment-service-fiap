package br.com.fiap.payment.service;

import br.com.fiap.payment.model.PaymentDTO;
import br.com.fiap.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {


    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public PaymentDTO findById(Long id) {
        return paymentRepository.findById(id);
    }

    public PaymentDTO findByIdTransaction(String idTransaction) {
        return paymentRepository.findByIdTransaction(idTransaction);
    }

    public PaymentDTO save(PaymentDTO PaymentDTO){
        return paymentRepository.save(PaymentDTO);
    }


    public PaymentDTO update(Long id, PaymentDTO paymentDTO){

        PaymentDTO paymentDb = paymentRepository.findById(id);

        if(paymentDb == null){
            return null;
        }

        paymentDTO.setId(paymentDb.getId());

        return paymentRepository.update(paymentDTO);
    }

    public PaymentDTO delete(Long id){
        return paymentRepository.delete(id);
    }

    public List<PaymentDTO> getOrders(){
        return paymentRepository.getPayments();
    }

}
