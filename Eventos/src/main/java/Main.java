
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // 👤 Usuários
        User joao = new User("João", "joao@email.com");
        User maria = new User("Maria", "maria@email.com");
        User ana = new User("Ana", "ana@email.com");

        // 🔗 Seguidores
        joao.follow(maria);
        joao.follow(ana);
        maria.follow(ana);

        // 🚫 Bloqueio (teste)
        //ana.block(joao);

        // 📅 Criando eventos (via publish)
        joao.publish("Festa", "Festa do João", LocalDateTime.now().plusDays(2));
        maria.publish("Workshop", "Java POO", LocalDateTime.now().plusDays(1));
        ana.publish("Evento passado", "Já aconteceu", LocalDateTime.now().minusDays(1));
        ana.publish("Hackathon", "24h código", LocalDateTime.now().plusDays(3));
        ana.publish("123","123",LocalDateTime.now().plusMonths(2));

        // 🧾 Mostrar timeline
        System.out.println("\n=== Timeline João ===");
        System.out.println(joao.showTimeline());

        // 👍 Reações
        joao.confirm(0);
        joao.confirm(0);
        joao.cancel(1);

        System.out.println("\n=== Após reações ===");
        System.out.println(joao.showTimeline());

        // 🗑️ Remover eventos passados
        joao.removePastEvents();

        System.out.println("\n=== Após remover eventos passados ===");
        System.out.println(joao.showTimeline());

        // 🔄 Ordenar timeline
        joao.sortTimelineByDate();

        System.out.println("\n=== Timeline ordenada ===");
        System.out.println(joao.showTimeline());

        // ✏️ Editar evento
        maria.editEvent(0,
                "Workshop Avançado",
                "POO + Streams",
                LocalDateTime.now().plusDays(5)
        );

        System.out.println("\n=== Timeline João após edição ===");
        System.out.println(joao.showTimeline());
    }
}

