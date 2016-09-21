#include "maliquizdb.h"


MaliquizDB::MaliquizDB()
{

}

FileDownloader MaliquizDB::synchronize(QString url)
{
    QUrl dbUrl(url);
    FileDownloader file = new FileDownloader(dbUrl, this);
    return file;
}

MaliquizDB::add()
{

}

MaliquizDB::update()
{

}

MaliquizDB::get()
{

}

MaliquizDB::remove()
{

}
