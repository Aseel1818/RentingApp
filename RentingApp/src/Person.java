import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private String name;
    ////// Aggregation ////////
    private List<Contract> contracts ;

    Person(String name){
        this.name = name;
        this.contracts= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Contract> getContracts() {
        return contracts;
    }
    public void setContracts(List<Contract>contracts){
        this.contracts = contracts;
    }

    public void addContract(Contract contract){
        contracts.add(contract);
    }
}
