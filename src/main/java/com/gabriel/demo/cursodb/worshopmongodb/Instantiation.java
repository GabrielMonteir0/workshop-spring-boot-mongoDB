package com.gabriel.demo.cursodb.worshopmongodb;

import com.gabriel.demo.cursodb.repository.PostRepository;
import com.gabriel.demo.cursodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.UUID;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

            Post post1 = new Post(UUID.randomUUID(), sdf.parse("21/03/2021"),"partiu viagem", "vou viajar abraço" );
            Post post2 = new Post(UUID.randomUUID(),  sdf.get2DigitYearStart(),"bom dia", "acordei feliz hoje");
            //postRepository.save(Arrays.asList(post1, post2));


            /*userRepository.deleteAll();
            User maria = new User("Maria Brown", "maria@gmail.com");
            User alex = new User("Alex Green", "alex@gmail.com");
            User bob = new User("Bob Grey", "bob@gmail.com");
            User Carlos = new User("Carlos Alexandre", "carlos@gmail.com");
            userRepository.saveAll(Arrays.asList(maria, alex, bob, Carlos));*/
        }
    }