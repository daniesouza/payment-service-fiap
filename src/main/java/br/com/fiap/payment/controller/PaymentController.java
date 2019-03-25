package br.com.fiap.payment.controller;

import br.com.fiap.payment.model.PaymentDTO;
import br.com.fiap.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/payment", produces = "application/json")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @GetMapping("/{idTransaction}")
    public ResponseEntity<PaymentDTO> findByIdTransaction(@PathVariable(value="idTransaction") String idTransaction){

        System.out.printf("findByIdTransaction %s", idTransaction);

        PaymentDTO paymentDTO = paymentService.findByIdTransaction(idTransaction);

        if(paymentDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(paymentDTO);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid PaymentDTO paymentDTO){

        paymentDTO = paymentService.save(paymentDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("{ \"payment\" : \"/payment/"+paymentDTO.getId()+ "\"}");
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid PaymentDTO paymentDTO) {

        paymentDTO = paymentService.update(id,paymentDTO);

        if(paymentDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body("{ \"payment\" : \"/payment/"+paymentDTO.getId()+ "\"}");
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }

    @GetMapping("/")
    public ResponseEntity<PaymentDTO> getPayments(PaymentDTO paymentDTO){
        log.info("getPayments {} {}", paymentDTO.getIdTransaction(), paymentDTO.getId());
        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }
}
