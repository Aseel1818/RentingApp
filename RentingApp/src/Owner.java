import java.util.ArrayList;
import java.util.List;

public class Owner extends Person{

    private List<Building> buildings;

    public Owner(String name){
        super(name);
        buildings = new ArrayList<>();
    }

    public void setBuilding(Building building){
        buildings.add(building);
    }

    public List<Building> getBuildings(){
        return buildings;
    }
    @Override
    public void addContract(Contract contract){
        getContracts().add(contract);
    }


}
