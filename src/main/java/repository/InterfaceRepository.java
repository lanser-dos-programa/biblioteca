package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterfaceRepository extends JpaRepository <LivroRepository,String>{

    @Override
    List<LivroRepository> findAllById(Iterable<String> strings);
}
