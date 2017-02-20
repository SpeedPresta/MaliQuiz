#ifndef PLAYER_H
#define PLAYER_H

#include <QString>

class Player
{
public:
    Player(QString name);
    QString getName();
    int getScore();
    QString getLevel();
    void storeScore(int score);
private:
    QString name;
    QString level;
    int score;
};

#endif // PLAYER_H
