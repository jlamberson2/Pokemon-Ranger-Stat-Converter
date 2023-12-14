public class StatConvert {
    int HP;
    int attack;
    int defense;
    int spAttack;
    int spDefense;
    int speed;

    int strength;
    int dexterity;
    int constitution;
    int wisdom;
    int intelligence;
    int charisma;

    public StatConvert(){
        HP = 0;
        attack = 0;
        defense = 0;
        spAttack = 0;
        spDefense = 0;
        speed = 0;

        strength = 0;
        dexterity = 0;
        constitution = 0;
        wisdom = 0;
        intelligence = 0;
        charisma = 0;
    }

    public StatConvert(int HP, int attack, int defense, int spAttack, int spDefense, int speed){
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.spDefense = spDefense;
        this.spAttack = spAttack;
        this.speed = speed;

        converter();
    }

    private void converter(){
        strength = attack / 10;
        dexterity = speed / 10;
        constitution = HP /10;
        wisdom = defense / 10;
        intelligence = spAttack / 10;
        charisma = spDefense / 10;

        if((attack%10)>= 5){
            strength+= 1;
        }
        if((speed%10)>= 5){
            dexterity+= 1;
        }
        if((HP%10)>= 5){
            constitution+= 1;
        }
        if((defense%10)>= 5){
            wisdom+= 1;
        }
        if((spAttack%10)>= 5){
            intelligence+= 1;
        }
        if((spDefense%10)>= 5){
            charisma+= 1;
        }
    }
}
