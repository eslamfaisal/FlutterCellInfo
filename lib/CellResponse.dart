class CellsResponse {
  List<CellType> neighboringCellList;
  List<CellType> primaryCellList;

  CellsResponse({this.neighboringCellList, this.primaryCellList});

  CellsResponse.fromJson(Map<String, dynamic> json) {
    if (json['neighboringCellList'] != null) {
      neighboringCellList = [];
      json['neighboringCellList'].forEach((v) {
        neighboringCellList.add(new CellType.fromJson(v));
      });
    }
    if (json['primaryCellList'] != null) {
      primaryCellList = [];
      json['primaryCellList'].forEach((v) {
        primaryCellList.add(new CellType.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.neighboringCellList != null) {
      data['neighboringCellList'] =
          this.neighboringCellList.map((v) => v.toJson()).toList();
    }
    if (this.primaryCellList != null) {
      data['primaryCellList'] =
          this.primaryCellList.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class CellType {
  String type;
  Wcdma wcdma;
  Nr nr;
  Lte lte;
  Gsm gsm;
  Tdscdma tdscdma;
  Cdma cdma;

  CellType(
      {this.type,
      this.wcdma,
      this.nr,
      this.lte,
      this.gsm,
      this.tdscdma,
      this.cdma});

  CellType.fromJson(Map<String, dynamic> json) {
    type = json['type'];
    wcdma = json['wcdma'] != null ? new Wcdma.fromJson(json['wcdma']) : null;
    nr = json['nr'] != null ? new Nr.fromJson(json['nr']) : null;
    lte = json['lte'] != null ? new Lte.fromJson(json['lte']) : null;
    gsm = json['gsm'] != null ? new Gsm.fromJson(json['gsm']) : null;
    tdscdma =
        json['tdscdma'] != null ? new Tdscdma.fromJson(json['tdscdma']) : null;
    cdma = json['cdma'] != null ? new Cdma.fromJson(json['cdma']) : null;
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['type'] = this.type;
    if (this.wcdma != null) {
      data['wcdma'] = this.wcdma.toJson();
    }
    if (this.nr != null) {
      data['nr'] = this.nr.toJson();
    }
    if (this.lte != null) {
      data['lte'] = this.lte.toJson();
    }
    if (this.gsm != null) {
      data['gsm'] = this.gsm.toJson();
    }
    if (this.tdscdma != null) {
      data['tdscdma'] = this.tdscdma.toJson();
    }
    if (this.cdma != null) {
      data['cdma'] = this.cdma.toJson();
    }
    return data;
  }
}

class Wcdma {
  BandWCDMA bandWCDMA;
  SignalWCDMA signalWCDMA;
  String connectionStatus;
  Network network;
  String type;

  Wcdma(
      {this.bandWCDMA,
      this.signalWCDMA,
      this.connectionStatus,
      this.network,
      this.type});

  Wcdma.fromJson(Map<String, dynamic> json) {
    bandWCDMA = json['bandWCDMA'] != null
        ? new BandWCDMA.fromJson(json['bandWCDMA'])
        : null;
    signalWCDMA = json['signalWCDMA'] != null
        ? new SignalWCDMA.fromJson(json['signalWCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandWCDMA != null) {
      data['bandWCDMA'] = this.bandWCDMA.toJson();
    }
    if (this.signalWCDMA != null) {
      data['signalWCDMA'] = this.signalWCDMA.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}

class BandWCDMA {
  int downlinkUarfcn;
  int channelNumber;
  String name;
  int number;

  BandWCDMA({this.downlinkUarfcn, this.channelNumber, this.name, this.number});

  BandWCDMA.fromJson(Map<String, dynamic> json) {
    downlinkUarfcn = json['downlinkUarfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['downlinkUarfcn'] = this.downlinkUarfcn;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}

class SignalWCDMA {
  int bitErrorRate;
  int ecio;
  int ecno;
  int rscp;
  int rscpAsu;
  int rssi;
  int rssiAsu;
  int dbm;

  SignalWCDMA(
      {this.bitErrorRate,
      this.ecio,
      this.ecno,
      this.rscp,
      this.rscpAsu,
      this.rssi,
      this.rssiAsu,
      this.dbm});

  SignalWCDMA.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    ecio = json['ecio'];
    ecno = json['ecno'];
    rscp = json['rscp'];
    rscpAsu = json['rscpAsu'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bitErrorRate'] = this.bitErrorRate;
    data['ecio'] = this.ecio;
    data['ecno'] = this.ecno;
    data['rscp'] = this.rscp;
    data['rscpAsu'] = this.rscpAsu;
    data['rssi'] = this.rssi;
    data['rssiAsu'] = this.rssiAsu;
    data['dbm'] = this.dbm;
    return data;
  }
}

class Network {
  String iso;
  String mcc;
  String mnc;

  Network({this.iso, this.mcc, this.mnc});

  Network.fromJson(Map<String, dynamic> json) {
    iso = json['iso'];
    mcc = json['mcc'];
    mnc = json['mnc'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['iso'] = this.iso;
    data['mcc'] = this.mcc;
    data['mnc'] = this.mnc;
    return data;
  }
}

class Nr {
  BandNR bandNR;
  int nci;
  int pci;
  SignalNR signalNR;
  int tac;
  String connectionStatus;
  Network network;
  String type;

  Nr(
      {this.bandNR,
      this.nci,
      this.pci,
      this.signalNR,
      this.tac,
      this.connectionStatus,
      this.network,
      this.type});

  Nr.fromJson(Map<String, dynamic> json) {
    bandNR =
        json['bandNR'] != null ? new BandNR.fromJson(json['bandNR']) : null;
    nci = json['nci'];
    pci = json['pci'];
    signalNR = json['signalNR'] != null
        ? new SignalNR.fromJson(json['signalNR'])
        : null;
    tac = json['tac'];
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandNR != null) {
      data['bandNR'] = this.bandNR.toJson();
    }
    data['nci'] = this.nci;
    data['pci'] = this.pci;
    if (this.signalNR != null) {
      data['signalNR'] = this.signalNR.toJson();
    }
    data['tac'] = this.tac;
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}

class BandNR {
  int downlinkArfcn;
  int downlinkFrequency;
  int channelNumber;
  String name;
  int number;

  BandNR(
      {this.downlinkArfcn,
      this.downlinkFrequency,
      this.channelNumber,
      this.name,
      this.number});

  BandNR.fromJson(Map<String, dynamic> json) {
    downlinkArfcn = json['downlinkArfcn'];
    downlinkFrequency = json['downlinkFrequency'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['downlinkArfcn'] = this.downlinkArfcn;
    data['downlinkFrequency'] = this.downlinkFrequency;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}

class SignalNR {
  int csiRsrp;
  int csiRsrpAsu;
  int csiRsrq;
  int csiSinr;
  int ssRsrp;
  int ssRsrpAsu;
  int ssRsrq;
  int ssSinr;
  int dbm;

  SignalNR(
      {this.csiRsrp,
      this.csiRsrpAsu,
      this.csiRsrq,
      this.csiSinr,
      this.ssRsrp,
      this.ssRsrpAsu,
      this.ssRsrq,
      this.ssSinr,
      this.dbm});

  SignalNR.fromJson(Map<String, dynamic> json) {
    csiRsrp = json['csiRsrp'];
    csiRsrpAsu = json['csiRsrpAsu'];
    csiRsrq = json['csiRsrq'];
    csiSinr = json['csiSinr'];
    ssRsrp = json['ssRsrp'];
    ssRsrpAsu = json['ssRsrpAsu'];
    ssRsrq = json['ssRsrq'];
    ssSinr = json['ssSinr'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['csiRsrp'] = this.csiRsrp;
    data['csiRsrpAsu'] = this.csiRsrpAsu;
    data['csiRsrq'] = this.csiRsrq;
    data['csiSinr'] = this.csiSinr;
    data['ssRsrp'] = this.ssRsrp;
    data['ssRsrpAsu'] = this.ssRsrpAsu;
    data['ssRsrq'] = this.ssRsrq;
    data['ssSinr'] = this.ssSinr;
    data['dbm'] = this.dbm;
    return data;
  }
}

class Lte {
  BandLTE bandLTE;
  int bandwidth;
  int cid;
  int eci;
  int enb;
  int pci;
  String ecgi;
  SignalLTE signalLTE;
  int tac;
  String connectionStatus;
  Network network;
  int subscriptionId;
  String type;

  Lte(
      {this.bandLTE,
      this.bandwidth,
      this.cid,
      this.eci,
      this.enb,
      this.pci,
      this.signalLTE,
      this.tac,
      this.ecgi,
      this.connectionStatus,
      this.network,
      this.subscriptionId,
      this.type});

  Lte.fromJson(Map<String, dynamic> json) {
    bandLTE =
        json['bandLTE'] != null ? new BandLTE.fromJson(json['bandLTE']) : null;
    bandwidth = json['bandwidth'];
    cid = json['cid'];
    eci = json['eci'];
    enb = json['enb'];
    ecgi = json['ecgi'];
    pci = json['pci'];
    signalLTE = json['signalLTE'] != null
        ? new SignalLTE.fromJson(json['signalLTE'])
        : null;
    tac = json['tac'];
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    subscriptionId = json['subscriptionId'];
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandLTE != null) {
      data['bandLTE'] = this.bandLTE.toJson();
    }
    data['bandwidth'] = this.bandwidth;
    data['cid'] = this.cid;
    data['eci'] = this.eci;
    data['enb'] = this.enb;
    data['pci'] = this.pci;
    data['ecgi'] = this.ecgi;
    if (this.signalLTE != null) {
      data['signalLTE'] = this.signalLTE.toJson();
    }
    data['tac'] = this.tac;
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network.toJson();
    }
    data['subscriptionId'] = this.subscriptionId;
    data['type'] = this.type;
    return data;
  }
}

class BandLTE {
  int downlinkEarfcn;
  int channelNumber;
  String name;
  int number;

  BandLTE({this.downlinkEarfcn, this.channelNumber, this.name, this.number});

  BandLTE.fromJson(Map<String, dynamic> json) {
    downlinkEarfcn = json['downlinkEarfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['downlinkEarfcn'] = this.downlinkEarfcn;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}

class SignalLTE {
  int cqi;
  double rsrp;
  int rsrpAsu;
  double rsrq;
  int rssi;
  int rssiAsu;
  double snr;
  int timingAdvance;
  int dbm;

  SignalLTE(
      {this.cqi,
      this.rsrp,
      this.rsrpAsu,
      this.rsrq,
      this.rssi,
      this.rssiAsu,
      this.snr,
      this.timingAdvance,
      this.dbm});

  SignalLTE.fromJson(Map<String, dynamic> json) {
    cqi = json['cqi'];
    rsrp = json['rsrp'];
    rsrpAsu = json['rsrpAsu'];
    rsrq = json['rsrq'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    snr = json['snr'];
    timingAdvance = json['timingAdvance'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['cqi'] = this.cqi;
    data['rsrp'] = this.rsrp;
    data['rsrpAsu'] = this.rsrpAsu;
    data['rsrq'] = this.rsrq;
    data['rssi'] = this.rssi;
    data['rssiAsu'] = this.rssiAsu;
    data['snr'] = this.snr;
    data['timingAdvance'] = this.timingAdvance;
    data['dbm'] = this.dbm;
    return data;
  }
}

class Gsm {
  BandGSM bandGSM;
  SignalGSM signalGSM;
  String connectionStatus;
  Network network;
  String type;

  Gsm(
      {this.bandGSM,
      this.signalGSM,
      this.connectionStatus,
      this.network,
      this.type});

  Gsm.fromJson(Map<String, dynamic> json) {
    bandGSM =
        json['bandGSM'] != null ? new BandGSM.fromJson(json['bandGSM']) : null;
    signalGSM = json['signalGSM'] != null
        ? new SignalGSM.fromJson(json['signalGSM'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandGSM != null) {
      data['bandGSM'] = this.bandGSM.toJson();
    }
    if (this.signalGSM != null) {
      data['signalGSM'] = this.signalGSM.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}

class BandGSM {
  int arfcn;
  int channelNumber;
  String name;
  int number;

  BandGSM({this.arfcn, this.channelNumber, this.name, this.number});

  BandGSM.fromJson(Map<String, dynamic> json) {
    arfcn = json['arfcn'];
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['arfcn'] = this.arfcn;
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}

class SignalGSM {
  int bitErrorRate;
  int rssi;
  int timingAdvance;
  int dbm;

  SignalGSM({this.bitErrorRate, this.rssi, this.timingAdvance, this.dbm});

  SignalGSM.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    rssi = json['rssi'];
    timingAdvance = json['timingAdvance'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bitErrorRate'] = this.bitErrorRate;
    data['rssi'] = this.rssi;
    data['timingAdvance'] = this.timingAdvance;
    data['dbm'] = this.dbm;
    return data;
  }
}

class Tdscdma {
  BandWCDMA bandTDSCDMA;
  SignalTDSCDMA signalTDSCDMA;
  String connectionStatus;
  Network network;
  String type;

  Tdscdma(
      {this.bandTDSCDMA,
      this.signalTDSCDMA,
      this.connectionStatus,
      this.network,
      this.type});

  Tdscdma.fromJson(Map<String, dynamic> json) {
    bandTDSCDMA = json['bandTDSCDMA'] != null
        ? new BandWCDMA.fromJson(json['bandTDSCDMA'])
        : null;
    signalTDSCDMA = json['signalTDSCDMA'] != null
        ? new SignalTDSCDMA.fromJson(json['signalTDSCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.bandTDSCDMA != null) {
      data['bandTDSCDMA'] = this.bandTDSCDMA.toJson();
    }
    if (this.signalTDSCDMA != null) {
      data['signalTDSCDMA'] = this.signalTDSCDMA.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}

class SignalTDSCDMA {
  int bitErrorRate;
  int rscp;
  int rscpAsu;
  int rssi;
  int rssiAsu;
  int dbm;

  SignalTDSCDMA(
      {this.bitErrorRate,
      this.rscp,
      this.rscpAsu,
      this.rssi,
      this.rssiAsu,
      this.dbm});

  SignalTDSCDMA.fromJson(Map<String, dynamic> json) {
    bitErrorRate = json['bitErrorRate'];
    rscp = json['rscp'];
    rscpAsu = json['rscpAsu'];
    rssi = json['rssi'];
    rssiAsu = json['rssiAsu'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['bitErrorRate'] = this.bitErrorRate;
    data['rscp'] = this.rscp;
    data['rscpAsu'] = this.rscpAsu;
    data['rssi'] = this.rssi;
    data['rssiAsu'] = this.rssiAsu;
    data['dbm'] = this.dbm;
    return data;
  }
}

class Cdma {
  Band band;
  int bid;
  SignalCDMA signalCDMA;
  String connectionStatus;
  Network network;
  String type;

  Cdma(
      {this.band,
      this.bid,
      this.signalCDMA,
      this.connectionStatus,
      this.network,
      this.type});

  Cdma.fromJson(Map<String, dynamic> json) {
    band = json['band'] != null ? new Band.fromJson(json['band']) : null;
    bid = json['bid'];
    signalCDMA = json['signalCDMA'] != null
        ? new SignalCDMA.fromJson(json['signalCDMA'])
        : null;
    connectionStatus = json['connectionStatus'];
    network =
        json['network'] != null ? new Network.fromJson(json['network']) : null;
    type = json['type'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.band != null) {
      data['band'] = this.band.toJson();
    }
    data['bid'] = this.bid;
    if (this.signalCDMA != null) {
      data['signalCDMA'] = this.signalCDMA.toJson();
    }
    data['connectionStatus'] = this.connectionStatus;
    if (this.network != null) {
      data['network'] = this.network.toJson();
    }
    data['type'] = this.type;
    return data;
  }
}

class Band {
  int channelNumber;
  String name;
  int number;

  Band({this.channelNumber, this.name, this.number});

  Band.fromJson(Map<String, dynamic> json) {
    channelNumber = json['channelNumber'];
    name = json['name'];
    number = json['number'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['channelNumber'] = this.channelNumber;
    data['name'] = this.name;
    data['number'] = this.number;
    return data;
  }
}

class SignalCDMA {
  int cdmaEcio;
  int cdmaRssi;
  int evdoEcio;
  int evdoRssi;
  int evdoSnr;
  int dbm;

  SignalCDMA(
      {this.cdmaEcio,
      this.cdmaRssi,
      this.evdoEcio,
      this.evdoRssi,
      this.evdoSnr,
      this.dbm});

  SignalCDMA.fromJson(Map<String, dynamic> json) {
    cdmaEcio = json['cdmaEcio'];
    cdmaRssi = json['cdmaRssi'];
    evdoEcio = json['evdoEcio'];
    evdoRssi = json['evdoRssi'];
    evdoSnr = json['evdoSnr'];
    dbm = json['dbm'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['cdmaEcio'] = this.cdmaEcio;
    data['cdmaRssi'] = this.cdmaRssi;
    data['evdoEcio'] = this.evdoEcio;
    data['evdoRssi'] = this.evdoRssi;
    data['evdoSnr'] = this.evdoSnr;
    data['dbm'] = this.dbm;
    return data;
  }
}
