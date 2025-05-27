package service;

import com.bibliotecaluca.demo.model.Emprestimo;
import com.bibliotecaluca.demo.model.Multa;
import com.bibliotecaluca.demo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public void verificarEMGerarMulta(Long emprestimoId) {
    Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
            .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

    if (emprestimo.getDataDevolucao() != null) return;

    long dias = ChronoUnit.DAYS.between(emprestimo.getDataEmprestimo(), LocalDate.now());

    if (dias > 15 && emprestimo.getMulta() == null) {
        Multa multa = new Multa();
        multa.setValor(20.0);
        multa.setPaga(false);
        multa.setEmprestimo(emprestimo);

        emprestimo.setMulta(multa);

        // Salva a multa junto com o empréstimo
        emprestimoRepository.save(emprestimo);
    }
}