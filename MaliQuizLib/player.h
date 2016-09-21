#ifndef PLAYER_H
#define PLAYER_H

#include <QString>

class Player
{
public:
    Player();
    QString getName();
    int getScore();
    QString getLevel();
    void storeScore(int score);
};

#endif // PLAYER_H
