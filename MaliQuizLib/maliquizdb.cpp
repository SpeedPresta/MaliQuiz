#include "maliquizdb.h"


MaliquizDB::MaliquizDB()
{

}

void MaliquizDB::synchronize(QString url)
{
     new FileDownloader(QUrl(url));
}

QJsonArray MaliquizDB::add(QJsonObject dataObject, QString rootName, QString key, QString value)
{
    QJsonValue dbMap = dataObject.value(rootName);
    QJsonArray dbMapArray = dbMap.toArray();
    // Add object
    QJsonObject currentValue;
    currentValue[key] = value;
    // Insertion
    dbMapArray.push_back(currentValue);
}

QJsonArray MaliquizDB::update(QJsonObject dataObject, QString rootName, QString key, QString value)
{
    // Search object
    QJsonValue dbMap = dataObject.find(rootName).value();
    QJsonArray dbMapArray = dbMap.toArray();
    QJsonArray::iterator ArrayIterator;
    QJsonObject currentObj;

    for (ArrayIterator = dbMapArray.begin(); ArrayIterator != dbMapArray.end(); ArrayIterator++) {
        QString keydb = ArrayIterator.a->first().toString();
        //QString value = ArrayIterator->second;
        if(keydb == key){
            dbMapArray.erase(ArrayIterator);
            currentObj[key] = value;
            dbMapArray.push_back(currentObj);
        }
     }
    return dbMapArray;
}

void MaliquizDB::remove(QJsonObject dataObject, QString rootName, QString key)
{
    // Search object
    QJsonValue dbMap = dataObject.find(rootName).value();
    QJsonArray dbMapArray = dbMap.toArray();
    QJsonArray::iterator ArrayIterator;


    for (ArrayIterator = dbMapArray.begin(); ArrayIterator != dbMapArray.end(); ArrayIterator++) {
       QString keydb = ArrayIterator.a->first().toString();
        if(keydb == key){
            dbMapArray.erase(ArrayIterator);
        }
    }
}

