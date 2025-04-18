import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        int opcao, valor;

        do {
            System.out.println("\n1. Inserir\n2. Remover\n3. Buscar\n4. InOrder\n5. PreOrder\n6. PostOrder\n7. Verificar tipo da árvore\n8. Grau de um nó\n9. Nível da árvore\n0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor: ");
                    valor = sc.nextInt();
                    bt.insert(valor);
                    break;
                case 2:
                    System.out.print("Valor: ");
                    valor = sc.nextInt();
                    bt.remove(valor);
                    break;
                case 3:
                    System.out.print("Valor: ");
                    valor = sc.nextInt();
                    System.out.println(bt.search(valor) ? "Encontrado!" : "Não encontrado.");
                    break;
                case 4:
                    bt.inOrder();
                    break;
                case 5:
                    bt.preOrder();
                    break;
                case 6:
                    bt.postOrder();
                    break;
                case 7:
                    System.out.println("Completa: " + bt.isComplete());
                    System.out.println("Cheia: " + bt.isFull());
                    System.out.println("Estrita: " + bt.isStrict());
                    break;
                case 8:
                    System.out.print("Valor: ");
                    valor = sc.nextInt();
                    int grau = bt.getGrau(valor);
                    if (grau == -1)
                        System.out.println("Nó não encontrado.");
                    else
                        System.out.println("Grau: " + grau);
                    break;
                case 9:
                    System.out.println("Nível da árvore: " + bt.nivel());
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }
}
