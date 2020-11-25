package com.example.TucShopBackend;


import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Token;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.TokenRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRunner implements CommandLineRunner {

//    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserDao userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {

//        userRepository.save(new User("b@b.com", "Admin", bcryptEncoder.encode("111"),true, "ADMIN", 1L, "TRAIL"));


//        Uncomment below lines if you want to create User and Admin By My runner.
//        LocalDate expireDate = LocalDate.now().plusMonths(1);
//        LocalDate accessDate = LocalDate.now();
//
//        userRepository.save(new User("t@t.com ", "usertest", bcryptEncoder.encode("111"),true, "USER", 1l, accessDate, expireDate,"trial"));
//        userRepository.save(new User("a@a.com ", "admintest", bcryptEncoder.encode("111"),true, "ADMIN", 1l, accessDate, expireDate,"trial"));

//        tokenRepository.save(new Token("lWOCaQ19Mn"));
//        tokenRepository.save(new Token("i49FRSwDXK"));
//        tokenRepository.save(new Token("Efb5ZgY6ru"));
//        tokenRepository.save(new Token("uchFS6Ykfg"));
//        tokenRepository.save(new Token("0JoMA2HlDg"));
//        tokenRepository.save(new Token("SAcdkVB4Es"));
//        tokenRepository.save(new Token("MFcguowYgo"));
//        tokenRepository.save(new Token("0fHIrsjJGt"));
//        tokenRepository.save(new Token("yZOhGjNBWa"));
//        tokenRepository.save(new Token("q4scXZSxY4"));
//        tokenRepository.save(new Token("nBgt6kaKBM"));
//        tokenRepository.save(new Token("VQ4yqwUZmY"));
//        tokenRepository.save(new Token("KU5UUR7aSY"));
//        tokenRepository.save(new Token("f1H2hHK282"));
//        tokenRepository.save(new Token("qCNSgD4aCx"));
//        tokenRepository.save(new Token("BWWxnyd4kL"));
//        tokenRepository.save(new Token("RYhxQHr6ol"));
//        tokenRepository.save(new Token("xusFt2DRbu"));
//        tokenRepository.save(new Token("RDnmxWL28B"));
//        tokenRepository.save(new Token("CXZGLZ9yr0"));
//        tokenRepository.save(new Token("o6uopLREEq"));
//        tokenRepository.save(new Token("GCfoFnUWOe"));
//        tokenRepository.save(new Token("RWtIzT0r9F"));
//        tokenRepository.save(new Token("BRZWW1eva7"));
//        tokenRepository.save(new Token("AT6pN6smbl"));
//        tokenRepository.save(new Token("CLSVPIlj1h"));
//        tokenRepository.save(new Token("zhfeLCNqhU"));
//        tokenRepository.save(new Token("rMv0HzjOJH"));
//        tokenRepository.save(new Token("6MbLUN8xlK"));
//        tokenRepository.save(new Token("7RhNAAIJvf"));
//        tokenRepository.save(new Token("lfg5xmmyBP"));
//        tokenRepository.save(new Token("cDXfxMyysU"));
//        tokenRepository.save(new Token("lg9Ibr4UXK"));
//        tokenRepository.save(new Token("eOqfpLh1aB"));
//        tokenRepository.save(new Token("vjTJC2Vg64"));
//        tokenRepository.save(new Token("tq0LGml7EF"));
//        tokenRepository.save(new Token("BdxGscmPUU"));
//        tokenRepository.save(new Token("lk41CjM1kq"));
//        tokenRepository.save(new Token("PyPM58lmSy"));
//        tokenRepository.save(new Token("PxuJpEMP2n"));
//        tokenRepository.save(new Token("frtWTLMqEq"));
//        tokenRepository.save(new Token("t24sFWSAl5"));
//        tokenRepository.save(new Token("Sw3r9Idh6L"));
//        tokenRepository.save(new Token("tLT4BwvthJ"));
//        tokenRepository.save(new Token("idfAWw6N4D"));
//        tokenRepository.save(new Token("k2NLVVGc7N"));
//        tokenRepository.save(new Token("q9KZhoJPkZ"));
//        tokenRepository.save(new Token("jInigD2nqm"));
//        tokenRepository.save(new Token("fRyqQHNZnX"));
//        tokenRepository.save(new Token("zcrRI9QmaX"));
//        tokenRepository.save(new Token("J0W6K0ShqG"));
//        tokenRepository.save(new Token("bdFhtdSofy"));
//        tokenRepository.save(new Token("6kMn25KsZ3"));
//        tokenRepository.save(new Token("hWpbpHTfUy"));
//        tokenRepository.save(new Token("KMWxGQUEBu"));
//        tokenRepository.save(new Token("Pz3sarohvc"));
//        tokenRepository.save(new Token("mD2efsPOTG"));
//        tokenRepository.save(new Token("vphciKXSN5"));
//        tokenRepository.save(new Token("3M2sadGf0r"));
//        tokenRepository.save(new Token("HMoMlEpv2T"));
//        tokenRepository.save(new Token("cmBcSVLGTr"));
//        tokenRepository.save(new Token("bdd4d0FjFi"));
//        tokenRepository.save(new Token("0EsjkNv6NH"));
//        tokenRepository.save(new Token("DvxIjfnI6H"));
//        tokenRepository.save(new Token("82h6Dlfvro"));
//        tokenRepository.save(new Token("Cw7KzJwaGZ"));
//        tokenRepository.save(new Token("4jWbPOCzon"));
//        tokenRepository.save(new Token("F8FSuQB1dL"));
//        tokenRepository.save(new Token("9VFONoJbqh"));
//        tokenRepository.save(new Token("hCT7MMvisu"));
//        tokenRepository.save(new Token("qsYkDFs6ja"));
//        tokenRepository.save(new Token("Eb8nCzucDt"));
//        tokenRepository.save(new Token("kCUgqbxC45"));
//        tokenRepository.save(new Token("E70Z135Gvz"));
//        tokenRepository.save(new Token("gwPwjkLbpL"));
//        tokenRepository.save(new Token("owauYkOFBz"));
//        tokenRepository.save(new Token("lR7h9Cnc3m"));
//        tokenRepository.save(new Token("yR7hhemOUE"));
//        tokenRepository.save(new Token("xuTKdKSXW8"));
//        tokenRepository.save(new Token("teis8lEOnM"));
//        tokenRepository.save(new Token("hlN024dxvX"));
//        tokenRepository.save(new Token("1yg1GHmH01"));
//        tokenRepository.save(new Token("J3YDMk715c"));
//        tokenRepository.save(new Token("GOMstWjz4I"));
//        tokenRepository.save(new Token("YjDnG6jWuH"));
//        tokenRepository.save(new Token("vwZOwqUlxZ"));
//        tokenRepository.save(new Token("Mk3zEbbxzO"));
//        tokenRepository.save(new Token("YkikxtVWX8"));
//        tokenRepository.save(new Token("zm1ze2bpCb"));
//        tokenRepository.save(new Token("pjaIzx678H"));
//        tokenRepository.save(new Token("B3b5yd8iLw"));
//        tokenRepository.save(new Token("60mPgzBkzt"));
//        tokenRepository.save(new Token("Yhr5Qa8Hh0"));
//        tokenRepository.save(new Token("N4qNQpBrTg"));
//        tokenRepository.save(new Token("Dl5RAY2ykK"));
//        tokenRepository.save(new Token("K8rUwtrk3x"));
//        tokenRepository.save(new Token("W91jLOMBvA"));
//        tokenRepository.save(new Token("YGuTdp8Vto"));
//        tokenRepository.save(new Token("YrchTTETRs"));
//        tokenRepository.save(new Token("qCgUDgTIr9"));
//        tokenRepository.save(new Token("pb7qSq4cDv"));
//        tokenRepository.save(new Token("j3bw4UBzPQ"));
//        tokenRepository.save(new Token("7QgiQzmKGG"));
//        tokenRepository.save(new Token("exlGiodoWt"));
//        tokenRepository.save(new Token("fDQeI7p6EM"));
//        tokenRepository.save(new Token("SUCMk9omHi"));
//        tokenRepository.save(new Token("EB5m5ZX2Lr"));
//        tokenRepository.save(new Token("mlEU8c5aWP"));
//        tokenRepository.save(new Token("Hlsu8gkkFX"));
//        tokenRepository.save(new Token("xSCdP0t7g1"));
//        tokenRepository.save(new Token("O0vbN1G4U7"));
//        tokenRepository.save(new Token("1eeRmgDbax"));
//        tokenRepository.save(new Token("GjIKqG6PGn"));
//        tokenRepository.save(new Token("Tmp9uAGpuN"));
//        tokenRepository.save(new Token("7eMn6u6VCE"));
//        tokenRepository.save(new Token("SapS9IZQ4X"));
//        tokenRepository.save(new Token("mzqXVkdjGO"));
//        tokenRepository.save(new Token("ZUsLHcbwi2"));
//        tokenRepository.save(new Token("dJSqTz11sF"));
//        tokenRepository.save(new Token("wMVY9177p8"));
//        tokenRepository.save(new Token("DlyJLpO1e7"));
//        tokenRepository.save(new Token("HWmS7nx6nl"));
//        tokenRepository.save(new Token("hwHZwB5xav"));
//        tokenRepository.save(new Token("aJmP6d7e3u"));
//        tokenRepository.save(new Token("01Sm1t2bqI"));
//        tokenRepository.save(new Token("TAif1uhIMh"));
//        tokenRepository.save(new Token("acsfTFArJ5"));
//        tokenRepository.save(new Token("SmvYUrdq0G"));
//        tokenRepository.save(new Token("awNPy7BSxx"));
//        tokenRepository.save(new Token("ZD9ZGU6bnU"));
//        tokenRepository.save(new Token("gqEC8yNeau"));
//        tokenRepository.save(new Token("pOCWdaYzaX"));
//        tokenRepository.save(new Token("rTb9B59Nfu"));
//        tokenRepository.save(new Token("sgF6yPolIC"));
//        tokenRepository.save(new Token("Vaatd0W8JH"));
//        tokenRepository.save(new Token("7fIVf2QcK6"));
//        tokenRepository.save(new Token("wQdbUcO91I"));
//        tokenRepository.save(new Token("oRD8eXnTXY"));
//        tokenRepository.save(new Token("vKH8patysw"));
//        tokenRepository.save(new Token("YuBQ0Y9blO"));
//        tokenRepository.save(new Token("UMRx3CEDWV"));
//        tokenRepository.save(new Token("x6EagWEzDi"));
//        tokenRepository.save(new Token("XQTsJCQNbU"));
//        tokenRepository.save(new Token("8cZjRENbyP"));
//        tokenRepository.save(new Token("2l4EcFZak8"));
//        tokenRepository.save(new Token("tPkwFgtvpg"));
//        tokenRepository.save(new Token("cMafmv37U4"));
//        tokenRepository.save(new Token("CaBzvyq7JM"));
//        tokenRepository.save(new Token("E0QMVhBL9E"));
//        tokenRepository.save(new Token("H01CMFHO7w"));
//        tokenRepository.save(new Token("wSK6TNBjVI"));
//        tokenRepository.save(new Token("fh41RTlv8J"));
//        tokenRepository.save(new Token("4egSUgMsdC"));
//        tokenRepository.save(new Token("7QmuJ2W8VZ"));
//        tokenRepository.save(new Token("JkIWTn5aZp"));
//        tokenRepository.save(new Token("v7YDn5n83u"));
//        tokenRepository.save(new Token("OdQMiGBCE6"));
//        tokenRepository.save(new Token("be4GzmrQdr"));
//        tokenRepository.save(new Token("HelW658yRG"));
//        tokenRepository.save(new Token("fz1jclo3yX"));
//        tokenRepository.save(new Token("oEwR9orl7g"));
//        tokenRepository.save(new Token("L3eWuOozzB"));
//        tokenRepository.save(new Token("gMJAxGzgSb"));
//        tokenRepository.save(new Token("DZacw264Qv"));
//        tokenRepository.save(new Token("TGLmfhaKh5"));
//        tokenRepository.save(new Token("SqMPae8TDQ"));
//        tokenRepository.save(new Token("MjoOmguO7V"));
//        tokenRepository.save(new Token("2uTQbDtjWe"));
//        tokenRepository.save(new Token("vtj2GGI13r"));
//        tokenRepository.save(new Token("JicxcWkiB2"));
//        tokenRepository.save(new Token("o6ennSGyRT"));
//        tokenRepository.save(new Token("8INUROaiQ5"));
//        tokenRepository.save(new Token("LmlaHMkxez"));
//        tokenRepository.save(new Token("cbHsUfROuF"));
//        tokenRepository.save(new Token("qmUTYwdOBL"));
//        tokenRepository.save(new Token("zRPQg5fZmv"));
//        tokenRepository.save(new Token("H0U48OE7kC"));
//        tokenRepository.save(new Token("OTZ7dEBE88"));
//        tokenRepository.save(new Token("nhpmVLIzL6"));
//        tokenRepository.save(new Token("b3CAZe3igE"));
//        tokenRepository.save(new Token("PIGrq3kkCY"));
//        tokenRepository.save(new Token("tM3hp1O0H0"));
//        tokenRepository.save(new Token("SqUeI9dNC5"));
//        tokenRepository.save(new Token("GoosXWfviX"));
//        tokenRepository.save(new Token("HjWdhtUN8O"));
//        tokenRepository.save(new Token("ppAuaeSMwI"));
//        tokenRepository.save(new Token("Ichi4BESOQ"));
//        tokenRepository.save(new Token("LzAxpiLkJ7"));
//        tokenRepository.save(new Token("9eWeK4Uu7U"));
//        tokenRepository.save(new Token("yqlMgwKmSC"));
//        tokenRepository.save(new Token("Px47az093C"));
//        tokenRepository.save(new Token("JKcKRQ8Oxr"));
//        tokenRepository.save(new Token("fbAj9wG2ZW"));
//        tokenRepository.save(new Token("iLNCflSMoO"));
//        tokenRepository.save(new Token("4AjCjVjgsw"));
//        tokenRepository.save(new Token("25Ra5flUh0"));
//        tokenRepository.save(new Token("gR3UJgohOd"));
//        tokenRepository.save(new Token("iJ8yPmZfMs"));
//        tokenRepository.save(new Token("KaaGUzpVf7"));
//        tokenRepository.save(new Token("kw9wNeTaCR"));
//        categoryRepository.save(new Category("Chips",null,null));

    }
}
