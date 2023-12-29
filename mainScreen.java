import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainScreen extends JFrame {
    mainScreen() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        add(new panelScreen());
        setVisible(true);
    }

    public static void main(String[] args) {
        new mainScreen();
    }
}

class panelScreen extends JPanel {
    int x1, y1, x2, y2;
    int count = 0;

    panelScreen() {
        setSize(800, 800);
        setLayout(null);
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("x = " + e.getX() + " " + "Y = " + e.getY());

                if (count == 0) {
                    x1 = e.getX();
                    y1 = e.getY();
                    count++;
                }
                else {
                    x2 = e.getX();
                    y2 = e.getY();
                    DDALine(x1, y1, x2, y2);
                    x1 = x2;
                    y1 = y2;
                }
                System.out.println("Click Count = " + count++);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }

        });
    }

    public void DDALine(int x1, int y1, int x2, int y2) {
        Graphics g = getGraphics();
        double dx, dy, x, y, step,xinc, yinc;

        dx = x2 - x1;
        dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy)) {
            step = Math.abs(dx);
        } else {
            step = Math.abs(dy);
        }

        xinc = (dx / step);
        yinc = (dy / step);

        x = x1;
        y = y1;

        g.setColor(Color.green);
        g.fillOval((int) x, (int) y, 2, 2);

        for (float i = 1; i <= step; i++) {
            x += xinc;
            y += yinc;
            g.fillOval((int) x, (int) y, 2, 2);
        }
    }
}