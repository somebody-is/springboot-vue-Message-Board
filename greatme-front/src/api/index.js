//API管理
import requests from './request'


export const reqGetCodeImage = () => {
  return requests({
    url: '/codeimage',
    method: 'post'
  });
}

export const reqLogin = (username, password) => {
  return requests({
    url: '/login',
    method: 'post',
    data: {
      username: username,
      password: password
    }
  });
}

export const reqSendEmail = (email) => {
  return requests({
    url: '/verify',
    method: 'post',
    data: {
      email: email
    }
  });
}

export const reqRegister = (email, password) => {
  return requests({
    url: '/register',
    method: 'post',
    data: {
      email: email,
      password: password
    }
  });
}

export const reqPublicMessage = () => {
  return requests({
    url: '/message/queryallpublic',
    method: 'post'
  })
}

export const reqGetContent = (id, password) => {
  return requests({
    url: '/message/getbyidandpsw',
    method: 'post',
    data: {
      id: id,
      password: password
    }
  })
}

export const reqQueryMessage = (messageKey) => {
  return requests({
    url: '/message/querybykey',
    method: 'post',
    data: {
      messageKey: messageKey
    }
  })
}

export const reqSendMessage = (form) => {
  return requests({
    url: '/message/add',
    method: 'post',
    data: {
      messageKey: form.messageKey,
      messageContent: form.messageContent,
      messageMaster: form.messageMaster,
      masterName: form.masterName,
      isLocked: form.isLocked,
      messagePassword: form.messagePassword,
      isPublic: form.isPublic
    }
  })
}
