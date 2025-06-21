package com.Locktalk.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Locktalk.Entity.Message;

@Repository
public interface messageRepo extends JpaRepository<Message,Integer> {

   List<Message> findBySecretAndPassword(String secret , String password);
}
