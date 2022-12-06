package hotciv.view;

import hotciv.framework.Unit;
import minidraw.standard.ImageFigure;

import java.awt.*;

/** UnitFigure is a MiniDraw figure that draws the graphics associated
 * with the proper images for HotCiv, and overlays some graphics that
 * tells ownership and move count left for the unit. The upper circle
 * is the owner color, the lower circle marks green for moves left
 * while red is for no more moves left.  
 *
 * SWEA Helper class.
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class UnitFigure extends ImageFigure {
  protected Unit associatedUnit;
  
  public UnitFigure(String name, Point origin, Unit unit) {
    super(name, origin);
    associatedUnit = unit;
  }

  @Override
  public void draw(Graphics g) {
    g.drawImage(fImage, fDisplayBox.x, 
        fDisplayBox.y - GfxConstants.UNIT_OFFSET_Y, 
        fDisplayBox.width, fDisplayBox.height, null);

    // Draw the owner circle
    Color color = 
      GfxConstants.getColorForPlayer(associatedUnit.getOwner());
    g.setColor(color);
    g.fillOval(fDisplayBox.x, fDisplayBox.y, 8, 6);
    g.setColor(Color.black);
    g.drawOval(fDisplayBox.x, fDisplayBox.y, 8, 6);
    
    // Draw the 'movable' box
    g.setColor( associatedUnit.getMoveCount() > 0 ? 
        Color.green : Color.red );
    g.fillOval(fDisplayBox.x, fDisplayBox.y+7, 8, 6);
    g.setColor(Color.black);
    g.drawOval(fDisplayBox.x, fDisplayBox.y+7, 8, 6);
  }
  
  
}
