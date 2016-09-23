#ifndef MALIQUIZDB_H
#define MALIQUIZDB_H

#include <QObject>
#include <QByteArray>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include <QJsonValue>
#include <QJsonArray>
#include <QJsonObject>
#include <QUrl>
#include "filedownloader.h"

class MaliquizDB
{
public:
    MaliquizDB();
    void synchronize(QString url);
    QJsonArray add(QJsonObject dataObject, QString rootName, QString key, QString value);
    QJsonArray update(QJsonObject dataObject, QString rootName, QString key, QString value);
    void remove(QJsonObject dataObject, QString rootName, QString key);
};

#endif // MALIQUIZDB_H
