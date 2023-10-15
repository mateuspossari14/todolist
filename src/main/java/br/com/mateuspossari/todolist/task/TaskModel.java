package br.com.mateuspossari.todolist.task;
//estrutura da tabela

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Generated;
import org.hibernate.Length;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

/*
 *
 * ID
 * Usuário (ID_USUARIO)
 * Descrição
 * Título
 * Data de Início
 * Data de Término
 * Prioridade
 *
 * */

@Data
@Entity(name = "tb_tasks") //criando tabela BD
public class TaskModel {

    @Id //chave primária (UUID id)
    @GeneratedValue(generator = "UUID") //gerar o ID automaticamente
    private UUID id;
    private String description;

    @Column(length = 50) //tamanho máx. do title
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception {
        if (title.length() > 50) {
            throw new Exception("O campo title deve conter no máximo 50 caracteres!");
        }
        this.title = title;
    }

}
