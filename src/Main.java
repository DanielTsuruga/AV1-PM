static List<Mecanico> mecanicos = new ArrayList<>();
static List<Box> boxes = new ArrayList<>();
static List<OrdemServico> ordens = new ArrayList<>();
static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    mecanicos.add(new Mecanico("Daniel", "1", "Motor", "91"));
    mecanicos.add(new Mecanico("Edmundo", "2", "Elétrica", "92"));
    mecanicos.add(new Mecanico("Romario", "3", "Combustor", "93"));

    boxes.add(new Box(1, "Motor", 4, "Galpão X"));
    boxes.add(new Box(2, "Elétrica", 1, "Galpão Y"));
    boxes.add(new Box(3, "Combustor", 3, "Galpão Z"));

    int opcao;
    do {
        System.out.println("\n--- OFICINA ---");
        System.out.println("1 - Cadastrar ordem");
        System.out.println("2 - Associar mecânico");
        System.out.println("3 - Atribuir ordem ao box");
        System.out.println("4 - Listar ordens do box");
        System.out.println("5 - Total finalizadas por box");
        System.out.println("6 - Buscar por status");
        System.out.println("7 - Detalhes da Ordem de Serviço");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        opcao = sc.nextInt(); sc.nextLine();

        if (opcao == 1) {
            System.out.print("Código: "); String codigo = sc.nextLine();
            System.out.print("Cliente: "); String cliente = sc.nextLine();
            System.out.print("Veículo/Placa: "); String modelo = sc.nextLine(); String placa = sc.nextLine();
            System.out.print("Serviço (Nome, Categoria(Motor/Elétrica/Combustor), Tempo, Valor): ");
            Servico s = new Servico(sc.next(), sc.nextDouble(), sc.nextDouble(), sc.next()); sc.nextLine();
            ordens.add(new OrdemServico(codigo, cliente, modelo, placa, "Hoje", 0, s));
            System.out.println("Ordem de Serviço cadastrada");
        }
        else if (opcao == 2) {
            System.out.print("Índice do mecânico (0-2): "); int m = sc.nextInt();
            System.out.print("Índice do box (0-2): "); int b = sc.nextInt();
            mecanicos.get(m).setBoxResponsavel(boxes.get(b));
            boxes.get(b).setMecanico(mecanicos.get(m));
            System.out.println("Associado com sucesso!");
        }
        else if (opcao == 3) {
            System.out.print("Código da Ordem de Serviço: "); String codigo = sc.next();
            System.out.print("Número do Box: "); int numeroBox = sc.nextInt();
            System.out.print("Novo Status (1 - Em execução, 2 - Encerrada): "); int st = sc.nextInt();

            for (OrdemServico o : ordens) {
                if (o.getCodigo().equals(codigo)) {
                    for (Box bx : boxes) {
                        if (bx.getNumero() == numeroBox && bx.getTipoServicoPermitido().equalsIgnoreCase(o.getServico().getCategoria())) {
                            o.setBox(bx);
                            o.setStatus(st == 2 ? "Encerrada" : "em execução");
                            System.out.println("Atualizado!");
                        }
                    }
                }
            }
        }
        else if (opcao == 4) {
            System.out.print("Número do Box: "); int numero = sc.nextInt();
            int total = 0;
            for (OrdemServico o : ordens) {
                if (o.getBox() != null && o.getBox().getNumero() == numero) {
                    System.out.println(o); total++;
                }
            }
            System.out.println("Total de ordens: " + total);
        }
        else if (opcao == 5) {
            for (Box b : boxes) {
                long count = ordens.stream().filter(o -> o.getStatus().equals("finalizada") && o.getBox() != null && o.getBox().getNumero() == b.getNumero()).count();
                System.out.println("Box " + b.getNumero() + " finalizadas: " + count);
            }
        }
        else if (opcao == 6) {
            System.out.print("Status desejado: "); String status = sc.next();
            ordens.stream().filter(o -> o.getStatus().equalsIgnoreCase(status)).forEach(System.out::println);
        }
        else if (opcao == 7) {
            System.out.print("Código da Ordem de Serviço: "); String codigo = sc.next();
            ordens.stream().filter(o -> o.getCodigo().equals(codigo)).forEach(o ->
                    System.out.println(o + " -- Serviço: " + o.getServico() + " -- Mecânico: " + (o.getBox() != null && o.getBox().getMecanico() != null ? o.getBox().getMecanico().getNome() : "Nenhum"))
            );
        }
    } while (opcao != 0);
}
