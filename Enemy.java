import java.awt.*;

public class Enemy {

    public double x;
    public double y;
    private double enemySpeedX;
    private double enemySpeedY;
    public Character character;
    private int enemyGoX;
    private int enemyGoY;
    //public double nX;
    //public double nY;
    public double xH;
    public double yH;
    public int startEnemy;
    public double enemyHealth;
    public boolean canHit;
    public boolean drawHealth;
    private long previousWorldUpdateTime;

    public Enemy(double x, double y, Character character) {
        this.x = x;
        this.y = y;
        this.xH = x + 10;
        this.yH = y - 10;
        this.enemySpeedX = 0.12;
        this.enemySpeedY = 0.12;
        this.character = character;
        this.enemyGoX = 0;
        this.enemyGoY = 0;
        this.startEnemy = 0;
        this.enemyHealth = 100;
        this.canHit = false;
        this.drawHealth = false;
        previousWorldUpdateTime = System.currentTimeMillis();

    }

    public void draw(Graphics g) {
        //if (enemyHealth > 0) {
        g.setColor(Color.MAGENTA);
        g.fillRect((int) x, (int) y, 40, 40);
        if (drawHealth) {
            g.drawString(String.valueOf(enemyHealth), (int) xH, (int) yH);
        }
        //}
    }


    public void update(long dt) {

        if (enemyHealth <= 0) {
            x = 1500;
            y = 500;
            xH = x + 10;
            yH = y - 10;
            drawHealth = false;
            enemyHealth = 100;
        }

        if (character.x - 5 > x + 35) {
            enemyGoX = 1;
        } else if (character.x + 55 < x) {
            enemyGoX = -1;
        } else if (character.x - 5 <= x + 35 && character.x + 55 >= x) {
            enemyGoX = 0;
        }

        if (character.y - 5 > y + 35) {
            enemyGoY = 1;
        } else if (character.y + 55 < y) {
            enemyGoY = -1;
        } else if (character.y - 5 <= y + 35 && character.y + 55 >= y) {
            enemyGoY = 0;
        }

        if (character.x > x - 300 && character.x < x + 340 && character.y > y - 300 && character.y < y + 340) {
            x += enemyGoX * enemySpeedX * dt;
            y += enemyGoY * enemySpeedY * dt;
            xH += enemyGoX * enemySpeedX * dt;
            yH += enemyGoY * enemySpeedY * dt;
            drawHealth = true;
        }
    }

    public void updateDamage(long dt) {
        //System.out.println(dt);
        long currentTime = System.currentTimeMillis();
        //System.out.println(previousWorldUpdateTime + ",   " + currentTime);
        if ((character.x - 5 <= x + 35 && character.x + 55 >= x) && (character.y - 5 <= y + 35 && character.y + 55 >= y)) {

            if ((currentTime - previousWorldUpdateTime) >= 1200) {
                previousWorldUpdateTime = currentTime;
                character.characterHealth -= 10;
                System.out.println("HIT");
            }
            //canHit = true;
        }
    }

    public void damage(long dt) {


        if (canHit) {

        }
    }

    /*public void start() {
        startEnemy = 1;
    }*/

    /*public void search(double x, double y) {
        nX = x;
        nY = y;

        if (nX > this.x) {
            enemyGoX = 1;
        } else if (nX < this.x) {
            enemyGoX = -1;
        } else {
            enemyGoX = 0;
        }

        if (nY > this.y) {
            enemyGoY = 1;
        } else if (nY < this.y) {
            enemyGoY = -1;
        } else {
            enemyGoY = 0;
        }
    }*/

    /*public void updateEnemy(long dt, double x, double y) {

        if (startEnemy == 1) {
            nX = x;
            nY = y;

            if (nX > this.x) {
                enemyGoX = 1;
            } else if (nX < this.x) {
                enemyGoX = -1;
            } else {
                //System.out.println("HHHHHH");
                enemyGoX = 0;
            }

            if (nY > this.y) {
                enemyGoY = 1;
            } else if (nY < this.y) {
                enemyGoY = -1;
            } else {
                enemyGoY = 0;
                //System.out.println("QQQQQQQQQQ");
            }


            if (enemyGoX == 1) {
                //System.out.println("YYYYYY");
                this.x += enemySpeedX * dt;
            } else if (enemyGoX == -1) {
                //System.out.println("YYYYYY");
                this.x -= enemySpeedX * dt;
            }

            if (enemyGoY == 1) {
                //System.out.println("JJJJJJ");
                this.y += enemySpeedY * dt;
            } else if (enemyGoY == -1) {
                //System.out.println("JJJJJJ");
                this.y -= enemySpeedY * dt;
            }
        }

       // System.out.println(x + ", " + y);


        /*if (nX != x) {
            enemyGoX = 0;
            //System.out.println("Yes");
        }

        if (nY != y) {
            //System.out.println("YYYYYES");
            enemyGoY = 0;
        }*/
    //}

    /*public void updateEnemy() {
        if (character.x > x - 200 && character.x < x + 240 && character.y > y - 200 && character.y < y + 240) {
            enemyGo = 1;
        }
    }*/
}
