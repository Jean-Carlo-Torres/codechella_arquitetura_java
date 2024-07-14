package br.com.alura.codechella.naousar;

import br.com.alura.codechella.infra.persistence.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

//    public DadosEvento cadastrarEvento(DadosCadastroEvento dados) {
//        EventoEntity eventoEntity = new EventoEntity(dados);
//        repository.save(eventoEntity);
//        return converteDados(eventoEntity);
//    }
//
//    public List<DadosEvento> listarTodos() {
//        List<EventoEntity> eventoEntities = repository.findAll();
//        return eventoEntities.stream()
//                .map(this::converteDados)
//                .toList();
//    }
//
//    private DadosEvento converteDados(EventoEntity eventoEntity) {
//        List<DadosCadastroTipoIngresso> dadosIngressos = eventoEntity.getTipoIngressos().stream()
//                .map(i -> new DadosCadastroTipoIngresso(i.getSetor(), i.getDefinicao(), i.getValor(), i.getTotalDisponivel()))
//                .toList();
//
//        return new DadosEvento(eventoEntity.getId(), eventoEntity.getCategoria(),
//                eventoEntity.getDescricao(), new DadosEndereco(eventoEntity.getEndereco().getCep(),
//                eventoEntity.getEndereco().getNumero(), eventoEntity.getEndereco().getComplemento()),
//                eventoEntity.getData(), dadosIngressos);
//    }
}
