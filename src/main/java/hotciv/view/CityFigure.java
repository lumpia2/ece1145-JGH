package hotciv.view;

import hotciv.framework.City;
import minidraw.standard.ImageFigure;

import java.awt.*;

/** A figure representing a city.

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

public class CityFigure extends ImageFigure {
  private City city;
  private Point position;

  public CityFigure(City c, Point p) {
    super("city", p); 
    position = p;
    city = c;
  }
  public void draw(Graphics g) {
    // draw background color
    g.setColor(GfxConstants.getColorForPlayer(city.getOwner()));
    g.fillRect( position.x+1, position.y+1, 
        GfxConstants.TILESIZE-2, 
        GfxConstants.TILESIZE-2 );

    super.draw(g);

    g.setColor(Color.white);

    Font font = new Font("Helvetica", Font.BOLD, 24);
    g.setFont(font);
    
    String size = ""+city.getSize();
    g.drawString(size, 
        position.x + GfxConstants.CITY_SIZE_OFFSET_X, 
        position.y + GfxConstants.CITY_SIZE_OFFSET_Y);
  }
}
