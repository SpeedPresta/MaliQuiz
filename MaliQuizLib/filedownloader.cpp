#include "filedownloader.h"

FileDownloader::FileDownloader(QUrl dbUrl, QObject *parent) :
 QObject(parent)
{
 connect(
  &m_WebCtrl, SIGNAL (finished(QNetworkReply*)),
  this, SLOT (fileDownloaded(QNetworkReply*))
  );

 QNetworkRequest request(dbUrl);
 m_WebCtrl.get(request);
}

FileDownloader::~FileDownloader() { }

void FileDownloader::fileDownloaded(QNetworkReply* pReply) {
 m_DownloadedData = pReply->readAll();
 //emit a signal
 pReply->deleteLater();
 emit downloaded();
}

QByteArray FileDownloader::downloadedData() const {
 return m_DownloadedData;
}

void FileDownloader::download(QUrl url) {
    FileDownloader(url, this);
}
