package funcionais;

import java.util.List;

public abstract class SQLParser {

    public abstract List<String> getCampos(String statement);

    public abstract String getTabela(String statement);

    public abstract String getRevertedScript(String tabela, List<String> campos);

}
