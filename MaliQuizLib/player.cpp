#include "player.h"


Player::Player(QString name)
{
    this->name = name;
    this->level = "starter";
    this->score = 0;
}

QString Player::getName()
{
    return name;
}

QString Player::getLevel()
{
    return level;
}

int Player::getScore()
{
    return score;
}
