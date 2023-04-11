package hack.api.com.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ola")
public class OlaController {


    @ApiOperation(value = "TESTE SEGURANÇA")
    @GetMapping
    public String findById(){
        return "OI";
    }
}
