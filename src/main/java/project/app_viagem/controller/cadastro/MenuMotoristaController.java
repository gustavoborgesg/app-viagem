package project.app_viagem.controller.cadastro;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.app_viagem.model.dto.ViagemInfoDTO;
import project.app_viagem.repository.MotoristaRepository;
import project.app_viagem.repository.ViagemRepository;
import project.app_viagem.service.cadastro.MenuMotoristaService;

import java.util.List;

@RestController
@RequestMapping("/menu/motorista/{motorista_id}")
@AllArgsConstructor
public class MenuMotoristaController {

    private MotoristaRepository motoristaRepository;
    private ViagemRepository viagemRepository;
    public MenuMotoristaService menuMotoristaService;

    @PostMapping("/{viagem_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ViagemInfoDTO cadastrarMotorista(@PathVariable("motorista_id") Long motorista_id, @PathVariable("viagem_id") Long viagem_id) {
        return menuMotoristaService.cadastrarViagem(motorista_id, viagem_id);
    }

    @GetMapping("/{viagem_id}")
    public ResponseEntity<ViagemInfoDTO> verViagemCadastrada(@PathVariable("motorista_id") Long motorista_id, @PathVariable("viagem_id") Long viagem_id) {
        return ResponseEntity.ok(menuMotoristaService.verViagemCadastrada(motorista_id, viagem_id));
    }

    @GetMapping
    public ResponseEntity<List<ViagemInfoDTO>> listarViagensCadastradas(@PathVariable("motorista_id") Long motorista_id) {
        return ResponseEntity.ok(menuMotoristaService.listarViagensCadastradas(motorista_id));
    }

    @DeleteMapping("/{viagem_id}")
    public ResponseEntity<Void> removerViagemCadastrada(@PathVariable("motorista_id") Long motorista_id, @PathVariable("viagem_id") Long viagem_id) {
        if (menuMotoristaService.removerViagemCadastrada(motorista_id, viagem_id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarViagensCadastradas(@PathVariable("motorista_id") Long motorista_id) {
        if (menuMotoristaService.deletarViagensCadastradas(motorista_id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

}
