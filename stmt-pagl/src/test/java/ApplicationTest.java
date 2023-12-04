import br.mil.fab.pagl.controller.VeiculoController;
import br.mil.fab.pagl.dao.VeiculoDAO;
import br.mil.fab.pagl.model.Veiculo;

public class ApplicationTest {
    public static void main(String[] args) {
        VeiculoDAO dao = new VeiculoController();

        /*TESTE CREATE*/
        dao.create(new Veiculo(null, "Gol", "Volkswagem", "LTS4561", 4, "Pneu Careca"));
    }
}
