#ifndef MALIQUIZDB_H
#define MALIQUIZDB_H

#include <QObject>
#include <QByteArray>
#include <QNetworkAccessManager>
#include <QNetworkRequest>
#include <QNetworkReply>
#include "filedownloader.h"

class MaliquizDB
{
public:
    MaliquizDB();
    FileDownloader synchronize(QString url);
};

#endif // MALIQUIZDB_H
