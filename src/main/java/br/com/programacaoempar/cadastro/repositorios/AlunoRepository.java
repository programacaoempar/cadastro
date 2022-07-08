package br.com.programacaoempar.cadastro.repositorios;

import br.com.programacaoempar.cadastro.entidades.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
}
