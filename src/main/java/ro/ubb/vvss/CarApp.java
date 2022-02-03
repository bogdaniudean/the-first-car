package ro.ubb.vvss;

import ro.ubb.vvss.controller.Controller;
import ro.ubb.vvss.exception.CustomException;
import ro.ubb.vvss.model.AccelerationStatus;
import ro.ubb.vvss.model.EngineStatus;
import ro.ubb.vvss.model.boardCommands.BoardCommands;
import ro.ubb.vvss.model.boardCommands.lights.Bulb;
import ro.ubb.vvss.model.boardCommands.lights.LightSwitch;
import ro.ubb.vvss.model.boardCommands.lights.Lights;
import ro.ubb.vvss.repository.TrunkItemRepository;
import ro.ubb.vvss.service.Service;
import ro.ubb.vvss.model.TrunkStatus;
import ro.ubb.vvss.ui.Ui;
import ro.ubb.vvss.validator.Validator;

public class CarApp
{
    public static void main(String[] args) throws CustomException {


        TrunkItemRepository trunkItemRepository = new TrunkItemRepository();
        TrunkStatus trunkStatus = new TrunkStatus();
        EngineStatus engineStatus = new EngineStatus();
        AccelerationStatus accelerationStatus = new AccelerationStatus();

        Bulb bulb = new Bulb();
        Lights lights = new Lights(bulb);
        LightSwitch lightSwitch = new LightSwitch(lights);
        BoardCommands boardCommands = new BoardCommands(lightSwitch);

        Service service = new Service(engineStatus,
                                      accelerationStatus,
                                      trunkStatus,
                                      trunkItemRepository,
                                      boardCommands);

        Validator validator = new Validator();
        Controller controller = new Controller(validator, service);

        Ui ui = new Ui(controller);

        ui.run();

    }
}
