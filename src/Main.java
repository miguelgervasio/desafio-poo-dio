import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o nome do desenvolvedor: ");
			String devNome = scanner.nextLine();

            if (devNome == null || devNome.trim().isEmpty()) {
                throw new DesenvolvedorInvalidoException("Nome obrigatório.");
            }

            Dev dev = new Dev();
            dev.setNome(devNome);
            dev.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos Inscritos " + devNome + ":" + dev.getConteudosInscritos());
            dev.progredir();
            dev.progredir();
            System.out.println("-");
            System.out.println("Conteúdos Inscritos " + devNome + ":" + dev.getConteudosInscritos());
            System.out.println("Conteúdos Inscritos " + devNome + ":" + dev.getConteudosConcluidos());
            System.out.println("XP:" + dev.calcularTotalXp());

            System.out.println("-------");

            Dev devJoao = new Dev();
            devJoao.setNome("Joao");
            devJoao.inscreverBootcamp(bootcamp);
            System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
            devJoao.progredir();
            devJoao.progredir();
            devJoao.progredir();
            System.out.println("-");
            System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
            System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
            System.out.println("XP:" + devJoao.calcularTotalXp());

        } catch (DesenvolvedorInvalidoException e) {
            System.out.println("O nome do desenvolvedor é obrigatório!");
        } finally {
            scanner.close();
        }
    }

}
