#include "maliquizlib.h"

QString quizStr;

MaliQuizLib::MaliQuizLib(const QString &quiz)
{
    quizStr = loadQuiz(quiz);
}

// get quizStr
QString MaliQuizLib::getQuizStr()
{
    return quizStr;
}

// Load Json file into a string
QString MaliQuizLib::loadQuiz(const QString &quiz)
{
    QFile file(quiz);
        if (!file.open(QFile::ReadOnly | QFile::Text)) {
            return QString();
        } else {
            QTextStream data(&file);
            return data.readAll();
        }
}

// Get key array
QJsonArray MaliQuizLib::getKeyArray(QString key)
{
    QJsonDocument document = QJsonDocument::fromJson(getQuizStr().toUtf8());
    QJsonObject jsonObject = document.object();
    QJsonArray jsonArray = jsonObject[key].toArray();
    return jsonArray;
}


// Get user identifiant
QString  MaliQuizLib::getMlqzID()
{
    return getKey(getKeyList("maliquiz", "id"), 0);
}


// Get app name
QString  MaliQuizLib::getMlqzName()
{
    return getKey(getKeyList("maliquiz", "name"), 0);
}

// Get KeyList
QStringList MaliQuizLib::getKeyList(QString option, QString key)
{
    QStringList result;
    foreach (const QJsonValue & value, getKeyArray(option)) {
        QJsonObject obj = value.toObject();
        result.append(obj[key].toString());
    }

    return result;
}

// Get Key
QString MaliQuizLib::getKey(QStringList list, int index)
{
    return list.value(index);
}



