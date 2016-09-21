#include "player.h"

QString name;
QString level;
int score;

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

QString Player::getScore()
{
    return score;
}
