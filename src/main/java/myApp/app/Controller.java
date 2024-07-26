package myApp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/card")
public class Controller {

    CardService cardService;

    @Autowired
    public Controller(CardService cardService) {
        this.cardService = cardService;
    }

    @PutMapping("/transfer")
    public ResponseEntity<Account> updateAccount(@RequestBody DTOForTransfer dto) throws SQLException {
        if (cardService.transferAmount(dto.getCardTo(), dto.getSumOfTransfer(), dto.getAccountFrom()))
            return new ResponseEntity<>(dto.getAccountFrom(), HttpStatus.CREATED);
        else
            return null;

    }

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) throws SQLException {
        System.out.println(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Account> getAccount(@PathVariable int id, @RequestBody Account account) throws SQLException {
        if(cardService.getInfoAboutUser(id, account)){
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        else return null;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{numCardTransferTo}")
    public ResponseEntity<Account> deleteAccount(@PathVariable int numCardTransferTo, @RequestBody Account account) {

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
