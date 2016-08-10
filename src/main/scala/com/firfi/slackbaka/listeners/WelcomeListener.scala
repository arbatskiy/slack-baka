package com.firfi.slackbaka.listeners

import akka.actor.{ActorRef, Actor}
import com.firfi.slackbaka.SlackBaka.{PrivateResponse, BakaResponse}
import slack.api.SlackApiClient
import slack.models.{UserTyping, User, TeamJoin}

class WelcomeListener(responder: ActorRef) extends Actor {
  override def receive: Receive = {
    case TeamJoin(user: User) => responder ! PrivateResponse(
     // s"Hey ${user.name} and welcome to our community!",
      """Привет!
        |
        |Эта конференция задумана как уютное место для общения на тематику фриланса и всего, что с ним связано. Здесь помогают стать успешным. Здесь все твои друзья. Здесь рады людям, которые только изучают программирование для вката в апворк, они получат хорошие советы. Главное - не прокрастинировать и катить колесо.
        |
        |Простые правила общения:
        |– здесь не Хабр: не надо занудничать про любимые технологии и насаждать своё личное мнение до победного по всем подряд темам.
        |– здесь не Двач: не надо троллировать, переходить на личности, и через слово употреблять сленг. Также следует держать в уме, что участников объединяет одно - программирование, фриланс или стремление стать фрилансером. Это не чатик ради чатика. Так что мимокрокам здесь не совсем рады.
        |– здесь не ЖЖ: не стоит постить про своих бывших, разводить политические срачи. Для этого у нас есть отдельные каналы, которые являются своего рода отстойниками. Писать туда каждый день по сотне сообщений тоже не стоит.
        |– уважай время других и компонуй одну мысль в одно сообщение. Новую строку в одном сообщении можно сделать с помощью Shift+Enter. Вот этой хуйни не надо:
        |`пaцаны`
        |`эй`
        |`есть один клиент`
        |`платит немного`
        |`8 долларов в час пока`
        |`как это`
        |`ставку у него поднять`
        |`знает кто?`
        |– хочешь что-то спросить  - просто спрашивай, без вступлений. В конфе почти все время кто-то есть, и рано или поздно тебе ответят.
        |
        |“Модераторов” у нас нет, и за каждым твоим сообщением никто следить не будет - достаточно просто быть здравомыслящим человеком. Бан можно схватить за постоянное жесткое нарушение каких-то вышеупомянутых рекомендаций и игнорирование просьб быть поадекватнее. Всего за почти год существования конфы бан был только один, так что нужно очень постараться его заслужить.
        |
        |Описание каналов:
        |
        |#upwork - вопросы, которые остались после прочтения гайда из шапки канала #guide. Охуительные истории связанные с фрилансом и клиентами.
        |#guide - если еще не читал гайд, то стоит зайти и прочитать перед задаванием вопросов в #upwork
        |#code - все, что касается (веб-)разработки и вопросы программирования. Здесь можно просить помощи и советов, однако не стоит путать канал со Stack Overflow.
        |#nix - филиал #code на тему линуксов и *никсов.
        |#nomads - вопросы про жизнь в других странах, стоимость жилья, вопросы по разного рода визам, иногда бывает кооперация с аноном.
        |#random - всё, что не относится к тематике других каналов (например, картинки с котятами и пони).
        |#ingrish-time - здесь можно попросить помощи в проверке текстов на английском.
        |#media - обмен музыкой, фильмами, играми, аниме, и обсуждение развлекательного контента вообще.
        |#money - вопросы, касающиеся обналичивания заработанных кровных. Способы вывода, легализация доходов, и ловкое уклонение от налогов и товарища майора - все здесь (и ежедневное обсуждение курса рубля и нефти, конечно).
        |#pol - полемика про политику, правильные режимы, “рашка загнила/встаёт с колен” и прочие схожие темы *только здесь*.
        |#bioproblems - здесь можно поплакаться о тян, рассказать о своём стаже тнн и прочее.
        |#yacht-club - об этом канале лишь ходят слухи.
        |
        |Также существует практика создания личных каналов людям, которые только начинают программировать и задают оче много банальных вопросов. Помощь они получают, достопочтенных сеньоров шокируют меньше. Win-Win.
        |
        |
        |А теперь стоит поздороваться в #upwork, рассказать о себе (фрилансишь ли уже или собираешься, на чём, стаж и прочее, что найдешь нужным сказать).
        |
        |Спасибо за внимание к нашему коммьюнити.""".stripMargin,
      user.id
    )
    // case UserTyping(channel: String, user: String) => responder ! PrivateResponse("test", "USERIDHERE")
  }
}