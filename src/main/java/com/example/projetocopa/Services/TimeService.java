package com.example.projetocopa.Services;

import com.example.projetocopa.Models.Grupo;
import com.example.projetocopa.Models.Jogador;
import com.example.projetocopa.Models.Time;
import com.example.projetocopa.repositories.GrupoRepository;
import com.example.projetocopa.repositories.TimeRepository;
import com.example.projetocopa.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class TimeService {

    @Autowired
    TimeRepository timeRepository;
    @Autowired
    GrupoRepository grupoRepository;
    @Autowired
    JogadorService jogadorService;

    public Time buscarPorId(Long id){
        return timeRepository.findFirstById(id);
    }

    public List<Time> buscarTimes(){
        return (List<Time>) timeRepository.findAll();
    }

    public void adicionar(Time time, Long grupoId){
        Grupo grupo = grupoRepository.findFirstById(grupoId);
        if (grupo.getTimes().size() <4) {
            time.setGrupo(grupo);
            timeRepository.save(time);
        }
    }

    public void deletar(Long id){
        for (Jogador jogador : timeRepository.findFirstById(id).getJogadores()){
            jogadorService.deletar(jogador.getId());
        }
        timeRepository.deleteById(id);
    }

    public String salvarImagem(MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String path = "./src/main/resources/static/img/times";
        Path uploadPath = Paths.get(path);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
        return fileName;
    }
}
