package hotciv.view;

import minidraw.standard.AbstractFigure;

import java.awt.*;

/** A figure representing a text.
 * Rather crude at the moment.

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
public class TextFigure extends AbstractFigure {
  private Point position;
  private String text;
  private Font fFont;
  FontMetrics metrics = null;

  public TextFigure(String text, Point position) {
    this.position = position;
    this.text = text;
    fFont = new Font("Serif", Font.BOLD, 20);
  }

  public void setText(String newText) {
    willChange();
    text = newText;
    changed();
  }

  protected void basicMoveBy(int dx, int dy) {
    position.translate(dx, dy);
  }

  public Rectangle displayBox() {
    Dimension extent = textExtent();
    return new Rectangle(position.x, position.y, extent.width, extent.height);
  }

  public void draw(Graphics g) {
    g.setFont(fFont);
    g.setColor( Color.white);
    metrics = g.getFontMetrics(fFont);
    g.drawString(text, position.x, position.y + metrics.getAscent());
  }

  private Dimension textExtent() {
    // metrics may not have been defined yet if no drawing
    // has occurred, however the error is removed upon first
    // redrawing.
    int fWidth;
    int fHeight; 
    if ( metrics == null ) {
      fWidth = 50;
      fHeight = 20;
    } else {
      fWidth = metrics.stringWidth(text);
      fHeight = metrics.getHeight();
    }
    return new Dimension(fWidth, fHeight);
  }
}
