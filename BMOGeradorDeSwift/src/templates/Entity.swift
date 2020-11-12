//
//  Entidade.swift
//  BMOGeradorDeSwift
//
//  Created by Breno Medeiros e João Paulo at 13/11/20
//  Copyright © 2020 BJ. All rights reserved.
//

import Foundation

protocol DocumentSerializable{
    init?(dictionary:[String:Any])
}

struct Entidade{
varAtributosDaStruct
    var dictionary : [String: Any]{
        return [
atributosDaStruct
        ]
    }
}
extension Entidade : DocumentSerializable{
    init?(dictionary:[String : Any]){
        guard let nome = dictionary["nome"] as? String,
        let data = dictionary["data"] as? String,
        let local = dictionary["local"] as? String,
        let imagem = dictionary["imagem"] as? String,
        let descricao = dictionary["descricao"] as? String else{return nil}
        self.init(contrutorNaExtension)
    }
}
