#-------------------------------------------------
#
# Project created by QtCreator 2016-09-15T13:55:22
#
#-------------------------------------------------

TARGET = MaliQuizLib
TEMPLATE = lib

QT     += network

DEFINES += MALIQUIZLIB_LIBRARY

SOURCES += maliquizlib.cpp \
    player.cpp \
    scores.cpp \
    maliquizdb.cpp \
    filedownloader.cpp

HEADERS += maliquizlib.h\
        maliquizlib_global.h \
    player.h \
    scores.h \
    maliquizdb.h \
    filedownloader.h

unix {
    target.path = /usr/lib
    INSTALLS += target
}
