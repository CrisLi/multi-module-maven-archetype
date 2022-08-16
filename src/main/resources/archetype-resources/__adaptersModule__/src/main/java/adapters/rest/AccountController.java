package ${package}.adapters.rest;

import ${package}.core.application.accounts.Deposit.DepositRequest;
import ${package}.core.application.accounts.GetAccount.GetAccountRequest;
import ${package}.core.application.accounts.GetAccount.GetAccountResponse;
import ${package}.core.application.accounts.OpenAccount.OpenAccountRequest;
import ${package}.core.application.accounts.OpenAccount.OpenAccountResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import an.awesome.pipelinr.Pipeline;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final Pipeline pipeline;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<GetAccountResponse> getAccount(@PathVariable String accountNumber) {

        GetAccountRequest request = GetAccountRequest.builder()
            .accountNumber(accountNumber)
            .build();

        GetAccountResponse response = pipeline.send(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<OpenAccountResponse> open() {

        OpenAccountRequest request = OpenAccountRequest.builder().build();

        OpenAccountResponse response = pipeline.send(request);

        return ResponseEntity.accepted()
            .body(response);
    }

    @PostMapping(value = "/{accountNumber}:deposit")
    public ResponseEntity<?> desposit(@PathVariable String accountNumber, @RequestBody DepositRequest body) {

        DepositRequest request = DepositRequest.builder()
            .accountNumber(accountNumber)
            .amount(body.getAmount())
            .build();

        pipeline.send(request);

        return ResponseEntity.accepted()
            .build();
    }

}
