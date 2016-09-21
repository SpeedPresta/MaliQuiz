#ifndef MALIQUIZLIB_H
#define MALIQUIZLIB_H

#include "maliquizlib_global.h"
#include <QFile>
#include <QJsonValue>
#include <QJsonArray>
#include <QJsonObject>
#include <QTextStream>
#include <QStringList>
#include <QJsonDocument>



class MALIQUIZLIBSHARED_EXPORT MaliQuizLib
{

public:
    MaliQuizLib(const QString &quiz);
    QString loadQuiz(const QString &quiz);
    QString getMlqzName();
    QString getMlqzID();
    QJsonArray getKeyArray(QString key);
    QStringList getKeyList(QString option, QString key);
    QString getKey(QStringList list, int index);
    QString getQuizStr();
};

#endif // MALIQUIZLIB_H
