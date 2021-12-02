package ggc.app.main;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;
import ggc.core.WarehouseManager;
//FIXME import classes
import java.io.IOException;
import ggc.core.exception.MissingFileAssociationException;

/**
 * Save current state to file under current name (if unnamed, query for name).
 */
class DoSaveFile extends Command<WarehouseManager> {
  private String _fileName;

  /** @param receiver */
  DoSaveFile(WarehouseManager receiver) {
    super(Label.SAVE, receiver);
  }

  @Override
  public final void execute() throws CommandException {
    //FIXME implement command and create a local Form
    Form form = new Form();

    try {
      if (_receiver.getLoadFile() == "") {
        form.addStringField("fileName", Message.newSaveAs());
        form.parse();
        _fileName = form.stringField("fileName");
        _receiver.saveAs(_fileName);
      }
      else {
        _receiver.save();
      }
    } catch (IOException | MissingFileAssociationException ex) {
      ex.printStackTrace();
    }
  }

}
